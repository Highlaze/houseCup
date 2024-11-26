package org.generation.italy.houseCup.viewModels;

import org.generation.italy.houseCup.model.entities.House;

public class HouseSelectViewModel {
    private long id;
    private String name;

    public HouseSelectViewModel(){

    }

    public HouseSelectViewModel(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static HouseSelectViewModel fromHouse(House h){
        var hs = new HouseSelectViewModel();
        hs.setId(h.getId());
        hs.setName(h.getHouseName());
        return hs;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
