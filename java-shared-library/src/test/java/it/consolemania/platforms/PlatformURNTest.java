package it.consolemania.platforms;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Platform URNs")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class PlatformURNTest {
    @Test
    void it_should_generate_platform_urns() {
        var platform = "Neo Geo AES";

        var urn = PlatformURN.of(platform);

        assertEquals("urn:platform:neo-geo-aes", urn.toString());
    }
}
