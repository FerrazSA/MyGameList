package com.centsa.mygamelist.projections;

public interface GameMinProjection {

    Long getId();
    String getTitle();
    int getYear();
    String getImgUrl();
    String getShortDescription();
    int getPosition();
}
