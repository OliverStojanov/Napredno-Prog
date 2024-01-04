package Zad14;

public class PlayState implements State {
    MP3Player mp3;
    public PlayState(MP3Player mp3Player) {
        mp3 = mp3Player;
    }
    @Override
    public void pressPlay() {
        System.out.println("Song is already playing");
    }

    @Override
    public void pressStop() {
        System.out.println("Song " + mp3.getSongIndex() + " is paused");
        mp3.setState(mp3.getPause());
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

