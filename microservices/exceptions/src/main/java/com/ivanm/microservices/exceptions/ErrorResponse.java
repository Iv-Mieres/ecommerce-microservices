package com.ivanm.microservices.exceptions;

import java.util.Map;

public record ErrorResponse(Map<String, String> errors) {
}
