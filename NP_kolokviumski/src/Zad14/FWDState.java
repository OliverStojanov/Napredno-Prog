package Zad14;

public class FWDState implements State {
    MP3Player mp3;
    public FWDState(MP3Player mp3Player) {
        mp3 = mp3Player;
    }
    @Override
    public void pressPlay() {
        System.out.println("Illegal action");
    }

    @Override
    public void pressStop() {
        System.out.println("Illegal action");
    }

    @Override
    public void pressFwd() {
        System.out.println("Illegal action");
    }

    @Override
    public void pressRew() {
        System.out.println("Illegal action");
    }
    @Override
    public void forward() {
        mp3.songFWD();
        mp3.setState(mp3.getPause());
    }

    @Override
    public void reward() {
        System.out.println("Illegal action");
    }
}
