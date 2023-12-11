package com.iwomi.reactive.model;

import com.iwomi.reactive.core.DatabaseEnum;

public record MessageModel(String action, DatabaseEnum status) {
}
