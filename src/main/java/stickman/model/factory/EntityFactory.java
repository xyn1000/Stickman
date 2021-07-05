package stickman.model.factory;

import stickman.model.entity.Entity;

import java.util.List;

public interface EntityFactory {
    Entity create(String type, double x, double y, List<Object> parameters);
}
