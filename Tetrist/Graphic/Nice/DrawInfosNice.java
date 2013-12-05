package Graphic.Nice;

import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics;

import java.net.URL;
import java.net.URLConnection;

import Component.Point;
import Component.Game;

import Graphic.Abstract.DrawInfos;

public class DrawInfosNice extends DrawInfos
{
    protected final Font font;
    protected static final int font_size = 20;
    protected static final int line_space = font_size + line_shift;

    public DrawInfosNice(Game g, Point offset) throws Exception
    {
        super(g, offset, 200, 200);
        font = init_font();
    }

    private Font init_font() throws Exception
    {
        Font f = null;

        String font_path = "/Fonts/heavy_data.ttf";
        URL font_url = getClass().getResource(font_path);
        URLConnection font_connection = font_url.openConnection();
        f = Font.createFont(Font.TRUETYPE_FONT, font_connection.getInputStream());
        f = f.deriveFont(Font.PLAIN, font_size);

        return f;
    }

    public void paint(Graphics g)
    {
        g.setColor(Color.yellow);
        g.setFont(font);
        paint_infos(g);
    }

    public void paint_infos(Graphics g)
    {
        g.drawString("Level: " + game.level(), offset_x,  0 + offset_y);
        g.drawString("Score: " + game.score(), offset_x, line_space + offset_y);
        g.drawString("Lines: " + game.lines_destroyed(), offset_x, 2 * line_space + offset_y);
    }
}