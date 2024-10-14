package com.luizamartins.life_manager.core.exceptions;

public class EntityNotFoundException extends RuntimeException{
    public EntityNotFoundException(){
        super("Entity Not Found");
    };
}
