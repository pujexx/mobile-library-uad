package com.pujexx.mlibraryuad.data;

/**
 * Created by pujexx on 11/8/14.
 */
public class Menu {

    private int id;
    private int icon;
    private String text_menu;

    public Menu(int id, int icon, String text_menu) {
        this.id = id;
        this.icon = icon;
        this.text_menu = text_menu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getText_menu() {
        return text_menu;
    }

    public void setText_menu(String text_menu) {
        this.text_menu = text_menu;
    }
}
