package com.m7g.common.voice;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record VoiceCommandRequest(
        @NotBlank String vehicleId,
        @NotNull VehicleCommandType commandType,
        String targetValue
) {
}

