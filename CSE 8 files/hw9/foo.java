import java.awt.*;

public class DrawFonts
{
   public static void main(String[] args)
   {
      DrawingPanel panel = new DrawingPanel(200,100);
      panel.setBackground(Color.PINK);

      Graphics g = panel.getGraphics();
      g.setFont(new Font("Monospaced", Font.BOLD + Font.ITALIC, 36));
      g.drawString("Too big", 20, 40);
   }
}
