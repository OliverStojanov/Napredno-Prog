package Zad42;

import java.util.ArrayList;
import java.util.List;

public class MovablesCollection {
    List<Movable> movables;
    static int XMAX;
    static int YMAX;
    public MovablesCollection(int xMax, int yMax) {
        XMAX = xMax;
        YMAX = yMax;
        movables = new ArrayList<>();
    }

    public static void setxMax(int i) {
        XMAX = i;
    }

    public static void setyMax(int i) {
        YMAX = i;
    }

    public void addMovableObject(Movable movable) throws MovableObjectNotFittableException {
        if(!movable.canBeFitted(XMAX,YMAX)){
            throw new MovableObjectNotFittableException(movable.getMessage());
        }
        movables.add(movable);
    }

    public void moveObjectsFromTypeWithDirection(TYPE type, DIRECTION direction) {
        movables.stream()
                .filter(movable -> movable.getType().equals(type))
                .forEach(movable -> {
                    try {
                        switch (direction) {
                            case UP:
                                movable.moveUp();
                                break;
                            case DOWN:
                                movable.moveDown();
                                break;
                            case LEFT:
                                movable.moveLeft();
                                break;
                            case RIGHT:
                                movable.moveRight();
                        }
                    }catch (ObjectCanNotBeMovedException e){
                        System.out.println(e.getMessage());
                    }
                });
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Collection of movable objects with size %d\n", movables.size()));
        for (Movable movable: movables) {
            sb.append(movable);
            sb.append("\n");
        }
        return sb.toString();
    }
}
