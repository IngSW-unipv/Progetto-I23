package it.unipv.ingsfw.ispafd.atl.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

public class ButtonCustom extends JButton {

    public ButtonStyle getStyle() {
        return style;
    }

    public void setStyle(ButtonStyle style) {
        if (this.style != style) {
            this.style = style;
            currentStyle.changeStyle(style);
        }
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
        repaint();
    }

    private ButtonStyle style = ButtonStyle.BLUE;
    private ButtonColor currentStyle = new ButtonColor(ButtonStyle.BLUE);
    private int round = 5;

    public ButtonCustom(String s) {
        setContentAreaFilled(false);
        setBorder(new EmptyBorder(8, 8, 8, 8));
        setForeground(Color.WHITE);
        setText(s);
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int x = 0;
        int y = 0;
        int width = getWidth();
        int height = getHeight();
        Area area = new Area(new RoundRectangle2D.Double(x, y, width, height, round, round));
        g2.setColor(currentStyle.background);
        g2.fill(area);
        area.subtract(new Area(new RoundRectangle2D.Double(x, y, width, height - 2, round, round)));
        g2.setColor(currentStyle.backgroundHover);
        g2.fill(area);
        g2.dispose();
        super.paintComponent(grphcs);
    }

    public enum ButtonStyle {
        BLUE(new Color(6, 94, 152));

        private ButtonStyle(Color background) {
            this.background = background;
        }
        private Color background;
    }

    protected class ButtonColor {

        public Color getBackground() {
            return background;
        }

        public void setBackground(Color background) {
            this.background = background;
        }

        public Color getBackgroundHover() {
            return backgroundHover;
        }

        public void setBackgroundHover(Color backgroundHover) {
            this.backgroundHover = backgroundHover;
        }

        public ButtonColor(ButtonStyle style) {
            changeStyle(style);
        }

        public ButtonColor() {
        }

        private Color background;
        private Color backgroundHover;

        private void changeStyle(ButtonStyle style) {
            this.background = style.background;
            this.backgroundHover = style.background;
        }
    }

}