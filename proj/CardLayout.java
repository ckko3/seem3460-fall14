import java.awt.*;
 
public class CardLayout implements LayoutManager {
    private int hshift;
    private int minWidth = 0, minHeight = 0;
    private int preferredWidth = 0, preferredHeight = 0;
    private boolean sizeUnknown = true;
 
    public CardLayout() {this(10);}
    
    public CardLayout(int h) {hshift = h;}
    
    /* Required by LayoutManager. */
    public void addLayoutComponent(String name, Component comp) {}
 
    /* Required by LayoutManager. */
    public void removeLayoutComponent(Component comp) {}
 
    private void setSizes(Container parent) {
        int nComps = parent.getComponentCount();
        Dimension d = null;
 
        //Reset preferred/minimum width and height.
        preferredWidth = 0;
        preferredHeight = 0;
        minWidth = 0;
        minHeight = 0;
 
        for (int i = 0; i < nComps; i++) {
            Component c = parent.getComponent(i);
            if (c.isVisible()) {
                d = c.getPreferredSize();
 
                if (i > 0) {
                    preferredWidth += hshift;
                } else {
                    preferredWidth = d.width;
                }
                preferredHeight = Math.max(preferredHeight, d.height);
 
                minWidth = Math.max(c.getMinimumSize().width, minWidth);
                minHeight = preferredHeight;
            }
        }
    }
 
    /* Required by LayoutManager. */
    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);
        int nComps = parent.getComponentCount();
 
        setSizes(parent);
 
        //Always add the container's insets!
        Insets insets = parent.getInsets();
        dim.width = preferredWidth + insets.left + insets.right;
        dim.height = preferredHeight + insets.top + insets.bottom;
        sizeUnknown = false;
 
        return dim;
    }
 
    /* Required by LayoutManager. */
    public Dimension minimumLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);
        int nComps = parent.getComponentCount();
 
        //Always add the container's insets!
        Insets insets = parent.getInsets();
        dim.width = minWidth + insets.left + insets.right;
        dim.height = minHeight + insets.top + insets.bottom;
 
        sizeUnknown = false;
 
        return dim;
    }
 
    /* Required by LayoutManager. */
    /*
     * This is called when the panel is first displayed,
     * and every time its size changes.
     * Note: You CAN'T assume preferredLayoutSize or
     * minimumLayoutSize will be called -- in the case
     * of applets, at least, they probably won't be.
     */
    public void layoutContainer(Container parent) {
        Insets insets = parent.getInsets();
        int maxWidth = parent.getWidth()
                       - (insets.left + insets.right);
        int maxHeight = parent.getHeight()
                        - (insets.top + insets.bottom);
        int nComps = parent.getComponentCount();
        int x = insets.left, y = insets.top;
        int xFudge = 0, yFudge = 0;
        boolean oneColumn = false;
 
        // Go through the components' sizes, if neither
        // preferredLayoutSize nor minimumLayoutSize has
        // been called.
        if (sizeUnknown) {
            setSizes(parent);
        }
 
        if (maxWidth <= minWidth) {
            oneColumn = true;
        }
 
        if (maxWidth < preferredWidth) {
            xFudge = (maxWidth - preferredWidth)/(nComps - 1);
        }
 
        if (maxHeight > preferredHeight) {
            yFudge = (maxHeight - preferredHeight)/(nComps - 1);
        }
 
        for (int i = 0 ; i < nComps ; i++) {
            Component c = parent.getComponent(nComps - i - 1);
            if (c.isVisible()) {
                Dimension d = c.getPreferredSize();
 
                 // increase x and y, if appropriate
                if (i > 0) {
                    if (!oneColumn) {
                        x += hshift + xFudge;
                    }
                }
 
                // If x is too large,
                if ((!oneColumn) &&
                    (x + d.width) >
                    (parent.getWidth() - insets.right)) {
                    // reduce x to a reasonable number.
                    x = parent.getWidth()
                        - insets.bottom - d.width;
                }
 
                // If y is too large,
                if ((y + d.height)
                    > (parent.getHeight() - insets.bottom)) {
                    // do nothing.
                    // Another choice would be to do what we do to x.
                }
 
                // Set the component's size and position.
                c.setBounds(x, y, d.width, d.height);
            }
        }
    }
 
    public String toString() {
        String str = "";
        return getClass().getName() + "[hshift=" + hshift + str + "]";
    }
}