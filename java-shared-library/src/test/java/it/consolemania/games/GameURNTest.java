package it.consolemania.games;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Game URNs")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class GameURNTest {
    @Test
    void it_should_generate_game_urns() {
        var platform = "Neo Geo AES";
        var gameTitle = "Fatal Fury 2";

        var urn = GameURN.of(platform, gameTitle);

        assertEquals("urn:game:neo-geo-aes:fatal-fury-2", urn.toString());
    }
}
