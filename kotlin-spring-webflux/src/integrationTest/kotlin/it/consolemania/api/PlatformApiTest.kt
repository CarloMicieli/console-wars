/*
 *   Copyright (c) 2023 Carlo Micieli
 *
 *    Licensed to the Apache Software Foundation (ASF) under one
 *    or more contributor license agreements.  See the NOTICE file
 *    distributed with this work for additional information
 *    regarding copyright ownership.  The ASF licenses this file
 *    to you under the Apache License, Version 2.0 (the
 *    "License"); you may not use this file except in compliance
 *    with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing,
 *    software distributed under the License is distributed on an
 *    "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *    KIND, either express or implied.  See the License for the
 *    specific language governing permissions and limitations
 *    under the License.
 */
package it.consolemania.api

import it.consolemania.AbstractWebApiTest
import org.junit.jupiter.api.Test
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import java.math.BigDecimal
import java.time.LocalDate
import java.time.Year
import java.util.UUID

private const val PLATFORMS = "/platforms"

class PlatformApiTest : AbstractWebApiTest() {
    @Test
    fun `should return BAD_REQUEST when the request body is empty`() {
        webClient.post()
            .uri(PLATFORMS)
            .accept(MediaType.APPLICATION_JSON)
            .contentType(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus().isEqualTo(HttpStatus.BAD_REQUEST)
            .expectBody()
            .jsonPath("$.detail").isEqualTo("Empty platform request")
            .jsonPath("$.title").isEqualTo("Bad Request")
            .jsonPath("$.type").isEqualTo("https://api.bookmarks.com/errors/bad-request")
    }

    @Test
    fun `should create a new platform`() {
        val name = UUID.randomUUID().toString()
        val newPlatform = PlatformRequest(
            name = name,
            manufacturer = "SNK",
            generation = 4,
            type = "HOME_VIDEO_GAME_CONSOLE",
            year = Year.of(1990),
            release = ReleaseRequest(
                japan = LocalDate.of(1990, 4, 26),
                northAmerica = LocalDate.of(1990, 8, 22),
                europe = LocalDate.of(1991, 1, 1)
            ),
            discontinuedYear = Year.of(1997),
            discontinued = true,
            introductoryPrice = BigDecimal.valueOf(649),
            unitsSold = 1000000,
            media = listOf("ROM_CARTRIDGE"),
            techSpecs = TechSpecsRequest(
                cpu = "Motorola 68000 @ 12MHz, Zilog Z80A @ 4MHz",
                memory = "64KB RAM, 84KB VRAM, 2KB Sound Memory",
                display = "320×224 resolution, 4096 on-screen colors out of a palette of 65536",
                sound = "Yamaha YM2610"

            )
        )

        webClient.post()
            .uri(PLATFORMS)
            .accept(MediaType.APPLICATION_JSON)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(newPlatform)
            .exchange()
            .expectStatus().isCreated
            .expectHeader().valueEquals("Location", "/platforms/urn:platform:$name")
    }
}

data class PlatformRequest(
    val name: String,
    val manufacturer: String,
    val generation: Int,
    val type: String,
    val year: Year,
    val release: ReleaseRequest,
    val discontinuedYear: Year?,
    val discontinued: Boolean,
    val introductoryPrice: BigDecimal?,
    val unitsSold: Int?,
    val media: List<String>,
    val techSpecs: TechSpecsRequest
)

data class ReleaseRequest(
    val japan: LocalDate?,
    val europe: LocalDate?,
    val northAmerica: LocalDate?
)

data class TechSpecsRequest(
    val cpu: String?,
    val memory: String?,
    val display: String?,
    val sound: String?
)
