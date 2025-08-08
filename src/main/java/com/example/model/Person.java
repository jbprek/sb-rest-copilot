package com.example.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Schema(description = "Person entity")
public record Person(
	@Schema(description = "First name of the person", example = "John")
	@NotNull(message = "First name must not be null")
	@Pattern(regexp = "[A-Z][a-zA-Z]*", message = "First name must start with a capital letter and contain only letters")
	String first,
	@Schema(description = "Last name of the person", example = "Doe")
	@NotNull(message = "Last name must not be null")
	@Pattern(regexp = "[A-Z][a-zA-Z]*", message = "Last name must start with a capital letter and contain only letters")
	String last
) {
}
