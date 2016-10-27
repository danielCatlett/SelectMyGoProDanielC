package com.example;

public class GoPro
{
    double price;
    int MP;
    int FPS;
    boolean fourK;
    boolean voiceControl;
    boolean videoStabilization;
    boolean touch;
    boolean cloud;
    boolean location;
    boolean rarWdrPhotos;

    public GoPro(double dollars, int MPixels, int FramesPS, boolean FK, boolean vControl, boolean vStab, boolean tou, boolean clo, boolean loc, boolean photos)
    {
        price = dollars;
        MP = MPixels;
        FPS = FramesPS;
        fourK = FK;
        voiceControl = vControl;
        videoStabilization = vStab;
        touch = tou;
        cloud = clo;
        location = loc;
        rarWdrPhotos = photos;
    }

    public double getPrice()
    {
        return price;
    }

    public int getMP()
    {
        return MP;
    }

    public int getFPS()
    {
        return FPS;
    }

    public boolean getVoiceControl()
    {
        return voiceControl;
    }

    public boolean getVideoStabilization()
    {
        return videoStabilization;
    }

    public boolean getTouch()
    {
        return touch;
    }

    public boolean getCloud()
    {
        return cloud;
    }

    public boolean getLocation()
    {
        return location;
    }

    public boolean getRarWdrPhotos()
    {
        return rarWdrPhotos;
    }

    public boolean getFourK()
    {
        return fourK;
    }
}
