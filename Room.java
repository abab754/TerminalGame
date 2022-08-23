import java.util.*;
public class Room {
    Room east;
    Room west;
    Room north;
    Room south;

    public boolean hasSouth, hasNorth, hasEast, hasWest, hasNoSouth, hasNoNorth, hasNoEast, hasNoWest;

    public Room(){

    }

    public void setHasEast(boolean bool){
        this.hasEast = bool;
    }

    public void setHasWest(boolean bool){
        this.hasWest = bool;
    }

    public void setHasNorth(boolean bool){
        this.hasNorth = bool;
    }

    public void setHasSouth(boolean bool){
        this.hasSouth = bool;
    }

    public void setHasNoNorth(boolean bool){
        this.hasNoNorth = bool;
    }

    public void setHasNoSouth(boolean bool){
        this.hasNoSouth = bool;
    }

    public void setHasNoWest(boolean bool){
        this.hasNoWest = bool;
    }

    public void setHasNoEast(boolean bool){
        this.hasNoEast = bool;
    }


    public Room getEast(Room room){
        return room.east;
    }


    public Room getWest(Room room){
        return room.west;
    }


    public Room getNorth(Room room){
        return room.north;
    }


    public Room getSouth(Room room){
        return room.south;
    }



}
