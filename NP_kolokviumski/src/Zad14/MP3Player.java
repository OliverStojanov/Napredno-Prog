package Zad14;

import java.util.List;

public class MP3Player{
    List<Song> songs;
    public int currSong;
    State play;
    State pause;
    State stop;
    State fwd;
    State rew;
    State state;

    final void createStates(){
        play = new PlayState(this);
        pause = new PauseState(this);
        stop = new StopState(this);
        fwd = new FWDState(this);
        rew = new REWState(this);
        state = stop;
    }

    public MP3Player(List<Song> songs) {
        this.songs = songs;
        currSong = 0;
        createStates();
    }

    public State getPlay() {
        return play;
    }

    public void setPlay(State play) {
        this.play = play;
    }

    public State getPause() {
        return pause;
    }

    public void setPause(State pause) {
        this.pause = pause;
    }

    public State getStop() {
        return stop;
    }

    public void setStop(State stop) {
        this.stop = stop;
    }

    public State getFwd() {
        return fwd;
    }

    public void setFwd(State fwd) {
        this.fwd = fwd;
    }

    public State getRew() {
        return rew;
    }

    public void setRew(State rew) {
        this.rew = rew;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
    public Song getCurrentSong() {
        return songs.get(currSong);
    }

    public void setSongIndex(int currentSong) {
        this.currSong = currentSong % songs.size();
    }

    public int getSongIndex() {
        return currSong;
    }

    public void songFWD() {
        currSong = (currSong+1)% songs.size();
    }

    public void songREW() {
        currSong = (currSong+songs.size()-1) % songs.size();
    }
    public void pressPlay() {
        state.pressPlay();
    }
    public void pressStop() {
        state.pressStop();
    }
    public void pressFWD(){
        state.pressFwd();
        state.forward();
    }

    public void pressREW(){
        state.pressRew();
        state.reward();
    }
    public void printCurrentSong() {
        System.out.println(getCurrentSong());
    }
    @Override
    public String toString() {
        return "MP3Player{currentSong = " + currSong + ", songList = " + songs + "}";
    }
}
