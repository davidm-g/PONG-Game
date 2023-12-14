package com.aor.pong.states;

import com.aor.pong.controller.Controller;
import com.aor.pong.controller.game.ArenaController;
import com.aor.pong.controller.menu.MenuController;
import com.aor.pong.model.game.arena.Arena;
import com.aor.pong.model.menu.Menu;
import com.aor.pong.viewer.Viewer;
import com.aor.pong.viewer.game.GameViewer;
import com.aor.pong.viewer.menu.MenuViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MenuStateTest {
    private Menu menuMock;
    private MenuState menuState;

    @BeforeEach
    public void setup(){
        menuMock = Mockito.mock(Menu.class);
        menuState = new MenuState(menuMock);
    }

    @Test
    public void testGetViewer(){
        Viewer<Menu> viewer = menuState.getViewer();
        assertEquals(MenuViewer.class,viewer.getClass());
    }
    @Test
    public void testGetController(){
        Controller<Menu> controller = menuState.getController();
        assertEquals(MenuController.class,controller.getClass());
    }
}
