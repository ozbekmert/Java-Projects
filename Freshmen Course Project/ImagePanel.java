package videodatabase;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {

    private Image image;

    public ImagePanel(URL url)
    {
        this(new ImageIcon(url).getImage());
    }

    public ImagePanel(Image image)
    {
        this.image = image;
        Dimension size = new Dimension(image.getWidth(null),image.getHeight(null));
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);
    }


    public void paintComponent(Graphics g) {
        g.drawImage(image,0,0,null);
    }

}