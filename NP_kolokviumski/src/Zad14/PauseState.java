package Zad14;

public class PauseState implements State {
    MP3Player mp3;
    public PauseState(MP3Player mp3) {
        this.mp3 = mp3;
    }

    @Override
    public void pressPlay() {
        System.out.println("Song " + mp3.getSongIndex() + " is playing");
        mp3.setState(mp3.getPlay());
    }

    @Override
    public void pressStop() {
        System.out.println("Songs are stopped");
        mp3.setSongIndex(0);
        mp3.setState(mp3.getStop());
    }

    @Override
    public void pressFwd() {
        System.out.println("Forward...");
        mp3.setState(mp3.getFwd());
    }

    @Override
    public void pressRew() {
        System.out.println("Reward...");
        mp3.setState(mp3.getRew());
    }

    @Override
    public void forward() {
        System.out.println("Illegal action");
    }

    @Override
    public void reward() {
        System.out.println("Illegal action");
    }
}
