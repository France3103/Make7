package view;

public class MouveHexagon{


    public static void setHexagon() {
        if (!PlayGround.isEmptyHexagon) {
            PlayGround.hex.setOnMouseDragged(event -> {

                PlayGround.hex.setX(event.getX());
                PlayGround.hex.setY(event.getY());

            });
        }
        PlayGround.hex.setOnMouseReleased(event -> PlayGround.randomHexagon());

        //PlayGround.hex.setOnMouseClicked(event -> System.out.print(PlayGround.hex.getName()));
    }
}
