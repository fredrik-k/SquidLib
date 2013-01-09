/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package squidpony.squidgrid.gui;

import java.awt.Color;
import java.awt.Font;

/**
 *
 * @author Eben Howard - http://squidpony.com - eben@squidpony.com
 */
public interface SGPane {
    
    /**
     * Returns the height of a single cell.
     * @return 
     */
    int getCellHeight();
    
    /**
     * Returns the width of a single cell.
     * 
     * @return 
     */
    int getCellWidth();

    /**
     * Returns the height of the grid. This is the number of rows in the grid.
     *
     * @return
     */
    int getGridHeight();

    /**
     * Returns the width of the grid. This is the number of columns in the grid.
     *
     * @return
     */
    int getGridWidth();

    /**
     * Initializes the component with the supplied values. The cells will be set
     * to the desired width and height and if the size of the font is too large,
     * it will be shrunk until everything fits.
     *
     * @param cellWidth in pixels
     * @param cellHeight in pixels
     * @param panelWidth in cells
     * @param panelHeight in cells
     * @param font
     */
    void initialize(int cellWidth, int cellHeight, int panelWidth, int panelHeight, Font font);

    /**
     * Initializes the component with the supplied number of rows and columns.
     * The size of the display will be adjusted to match the requested font size
     * as closely as possible.
     *
     * @param panelWidth in cells
     * @param panelHeight in cells
     * @param font
     */
    void initialize(int panelWidth, int panelHeight, Font font);

    /**
     * Sets one specific block to the given character.
     *
     * This block is not drawn immediately, refresh() must be called to update
     * display.
     *
     * @param x The x coordinate to set
     * @param y The y coordinate to set
     * @param c The character to be displayed
     */
    void placeCharacter(int x, int y, char c);

    /**
     * Sets one specific block to the given character with the given foreground
     * and background colors.
     *
     * This block is not drawn immediately, refresh() must be called to update
     * display.
     *
     * @param x The x coordinate to set
     * @param y The y coordinate to set
     * @param c The character to be displayed
     * @param fore The foreground color
     * @param back The background color
     */
    void placeCharacter(int x, int y, char c, Color fore, Color back);

    /**
     * Sets the block at the given coordinates to contain the passed in
     * character drawn with the given foreground color. The default background
     * color will be used.
     *
     * @param x
     * @param y
     * @param c
     * @param fore
     */
    void placeCharacter(int x, int y, char c, Color fore);

    /**
     * Prints out a string starting at the given offset position. Any portion of
     * the string that would cross the edge is ignored.
     *
     * @param string
     * @param xOffset
     * @param yOffset
     */
    void placeHorizontalString(int xOffset, int yOffset, String string);

    /**
     * Prints out a string vertically starting at the given offset position and
     * traveling down.
     *
     * @param xOffset
     * @param yOffset
     * @param string
     * @param foreground
     * @param background
     */
    void placeHorizontalString(int xOffset, int yOffset, String string, Color foreground, Color background);

    /**
     * Places the image associated with the provided key at the given
     * coordinates.
     *
     * If the key does not have an associated image, the factory's default null
     * image is used.
     *
     * @param x
     * @param y
     * @param key
     */
    void placeImage(int x, int y, String key);

    /**
     * Places the image associated with the provided key at the given
     * coordinates.
     *
     * If the key does not have an associated image, the factory's default null
     * image is used.
     *
     * The background will be set to the provided Color, but will only show up
     * if the keyed image has transparency.
     *
     * @param x
     * @param y
     * @param key
     * @param background
     */
    void placeImage(int x, int y, String key, Color background);

    /**
     * Sets the contents of the component to reflect the two dimensional
     * character array, starting at the given offset position.
     *
     * Any content that would be off the screen to the right or down is ignored.
     *
     * @param chars
     * @param xOffset
     * @param yOffset
     */
    void placeText(int xOffset, int yOffset, char[][] chars);

    /**
     * Sets the contents of the component to reflect the two dimensional
     * character array, starting at the given offset position.
     *
     * @param xOffset
     * @param yOffset
     * @param chars
     * @param foreground
     * @param background
     */
    void placeText(int xOffset, int yOffset, char[][] chars, Color foreground, Color background);

    /**
     * Prints out a string starting at the given offset position. Any portion of
     * the string that would cross the edge is ignored.
     *
     * @param xOffset
     * @param yOffset
     * @param string
     * @param foreground
     * @param background
     */
    void placeVerticalString(int xOffset, int yOffset, String string, Color foreground, Color background);

    /**
     * Prints out a string vertically starting at the given offset position and
     * traveling down.
     *
     * @param xOffset
     * @param yOffset
     * @param string
     */
    void placeVerticalString(int xOffset, int yOffset, String string);

    /**
     * Signals that this component should update its display image.
     */
    void refresh();

    /**
     * Sets the background color which will be used on all text and transparent
     * tiles when not other color is specified.
     *
     * @param defaultBackground
     */
    void setDefaultBackground(Color defaultBackground);

    /**
     * Sets the background color which will be used on all text and transparent
     * tiles when not other color is specified.
     *
     * @param defaultForeground
     */
    void setDefaultForeground(Color defaultForeground);

    /**
     * Sets the contents of the component to reflect the two dimensional
     * character array. Will ignore any portion of the array that is outside the
     * bounds of the component itself.
     *
     * The default colors of the foreground and background will be used.
     *
     * @param chars
     */
    void setText(char[][] chars);

    /**
     * Test if the given character will fit in the current cell dimension using
     * the current Font.
     *
     * @param character
     * @return true if it will fit, false otherwise.
     */
    boolean willFit(char character);
    
}