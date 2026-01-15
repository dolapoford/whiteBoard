package com.pm.whiteboard.dto;

import com.pm.whiteboard.model.Shape;
import lombok.Data;

@Data
public class ShapeResponse {
    private Long id;
    private String boardId;
    private String type;
    private Double x;
    private Double y;
    private Double width;
    private Double height;
    private String color;
    private Double rotation;
    private String text;
    private String createdBy;

    public static ShapeResponse  fromShape(Shape shape){
        ShapeResponse shapeResponse = new ShapeResponse();
        shapeResponse.setId(shape.getId());
        shapeResponse.setBoardId(shape.getBoardId());
        shapeResponse.setType(shape.getType());
        shapeResponse.setX(shape.getX());
        shapeResponse.setY(shape.getY());
        shapeResponse.setWidth(shape.getWidth());
        shapeResponse.setHeight(shape.getHeight());
        shapeResponse.setColor(shape.getColor());
        shapeResponse.setRotation(shape.getRotation());
        shapeResponse.setText(shape.getText());
        shapeResponse.setCreatedBy(shape.getCreatedBy());
        return shapeResponse;
    }
}
