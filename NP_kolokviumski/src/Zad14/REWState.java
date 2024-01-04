package Zad14;

public class REWState implements State {
    MP3Player mp3;
    public REWState(MP3Player mp3Player) {
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
        System.out.println("Illegal action");
    }

    @Override
    public void reward() {
        mp3.songREW();
        mp3.setState(mp3.getPause());
    }
}
