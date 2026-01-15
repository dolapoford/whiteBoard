package com.pm.whiteboard.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateBoardRequest {

    @NotBlank(message = "Board name is required")
    @Size(min = 3 , max = 100 , message = "Board name must be between 3 and 100 characters")
    private String name;

    @Size(max = 500 , message = "Description can be up to 500 characters")
    private String description;
}
