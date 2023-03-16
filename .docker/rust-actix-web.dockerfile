FROM rust:1.68 as builder
WORKDIR /app

COPY rust-actix-web/ .

ENV SQLX_OFFLINE true

RUN cargo build --release --bin rust-actix-web


FROM debian:bullseye-slim as runtime
ARG APP=/usr/src/app

HEALTHCHECK --interval=5m --timeout=3s \
  CMD curl -f http://localhost/health-check || exit 1

RUN apt-get update \
    && apt-get install -y ca-certificates tzdata curl \
    && rm -rf /var/lib/apt/lists/*

ENV TZ=Etc/UTC \
    APP_USER=appuser

RUN groupadd $APP_USER \
    && useradd -g $APP_USER $APP_USER \
    && mkdir -p ${APP} \
    && mkdir -p ${APP}/config

COPY --from=builder /app/target/release/rust-actix-web ${APP}/rust-actix-web
COPY --from=builder /app/src/config/application-docker.yaml ${APP}/src/config/application.yaml

RUN chown -R $APP_USER:$APP_USER ${APP}

USER $APP_USER
WORKDIR ${APP}

CMD ["./rust-actix-web"]
