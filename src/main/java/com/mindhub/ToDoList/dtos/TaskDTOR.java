package com.mindhub.ToDoList.dtos;

import java.util.UUID;

public record TaskDTOR(UUID id, String name, Boolean done) {
}
