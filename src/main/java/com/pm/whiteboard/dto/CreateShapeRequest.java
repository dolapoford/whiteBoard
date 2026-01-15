package com.pm.whiteboard.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateShapeRequest {

    @NotBlank(message = "Board Id is required")
    private String boardId;

    @NotBlank(message = "Type is required")
    private String type;

    @NotBlank(message = "X coordinate is required")
    private Double x;

    @NotBlank(message = "Y coordinate is required")
    private Double y;


    private Double width;
    private Double height;

    @NotBlank(message = "Color is required")
    private String color;

    private Double rotation;
    private String text;
    private String createdBy;
}
