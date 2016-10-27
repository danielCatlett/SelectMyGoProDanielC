package com.example;
import java.util.Scanner;

public class MyClass
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        GoPro Hero5Black = new GoPro(399.99, 12, 30, true, true, true, true, true, true, true);
        GoPro Hero5Session = new GoPro(299.99, 10, 30, true, true, true, false, true, false, false);
        GoPro HeroSession = new GoPro(199.99, 8, 10, false, false, false, false, false, false, false);

        System.out.println("This program will help you decide which GoPro camera you should get. Would you rather decide by price, or by features?");
        String decision = in.next();

        while(!decision.equals("price") && !decision.equals("features"))
        {
            System.out.println("Invalid response. Please type either \"price\" or \"features\", and be advised that it is case sensitive.");
            decision = in.next();
        }

        if(decision.equals("price"))
        {
            System.out.print("Enter a price you would be willing to pay. We will find you the GoPro closest to that price. \n$");
            double priceIn = in.nextDouble();
            findClosestPrice(priceIn, Hero5Black.getPrice(), Hero5Session.getPrice(), HeroSession.getPrice());
        }
        else
        {
            findClosestFeatures(Hero5Black, Hero5Session, HeroSession);
        }
    }



    public static void findClosestPrice(double priceIn, double price, double price1, double price2)
    {
        double difference = Math.abs(priceIn-price);
        double difference1 = Math.abs(priceIn-price1);
        double difference2 = Math.abs(priceIn-price2);

        if(Math.min(difference, Math.min(difference1, difference2)) == difference2)
            System.out.println("You should get the Hero Session, coming in at 199.99");
        else if(Math.min(difference, Math.min(difference1, difference2)) == difference1)
            System.out.println("You should get the Hero5 Session, coming in at 299.99");
        else
            System.out.println("You should get the Hero5 Black, coming in at 399.99");
    }

    public static void findClosestFeatures(GoPro hero5Black, GoPro hero5Session, GoPro heroSession)
    {
        Scanner in = new Scanner(System.in);

        System.out.println("Which camera resolution (in megapixels) is your preference? 12, 10, or 8");
        int preferredMP = in.nextInt();

        while(preferredMP != 12 && preferredMP != 10 && preferredMP != 8)
        {
            System.out.println("Invalid response! Please enter 12, 10, or 8.");
            preferredMP = in.nextInt();
        }

        System.out.println("Which max framerate do you prefer, 30 or 10?");
        int preferredFPS = in.nextInt();

        while(preferredFPS != 30 && preferredFPS != 10)
        {
            System.out.println("Invalid response! Please enter 30 or 10");
            preferredFPS = in.nextInt();
        }

        System.out.println("We will now list off seven features that are available in some GoPro models, but not all.\nPlease type a y if you want the feature, or a n if you don't.");

        boolean fourK = boolFeatures("4K Resolution");
        boolean voiceControl = boolFeatures("Voice Control");
        boolean videoStabilization = boolFeatures("Video Stabilization");
        boolean touch = boolFeatures("Touch Display");
        boolean cloud = boolFeatures("Auto-Upload to Cloud");
        boolean location = boolFeatures("Location Capture");
        boolean rarWdrPhotos = boolFeatures("RAW + WDR Photos");

        findCorrectGoPro(preferredMP, preferredFPS, fourK, voiceControl, videoStabilization, touch, cloud, location, rarWdrPhotos, hero5Black, hero5Session, heroSession);
    }

    public static void findCorrectGoPro(int preferredMP, int preferredFPS, boolean fourK, boolean voiceControl, boolean videoStabilization, boolean touch, boolean cloud, boolean location, boolean rarWdrPhotos, GoPro hero5Black, GoPro hero5Session, GoPro heroSession)
    {
        int blackCorrect = 0;

        if(preferredMP == hero5Black.getMP())
            blackCorrect++;
        if(preferredFPS == hero5Black.getFPS())
            blackCorrect++;
        if(fourK == hero5Black.getFourK())
            blackCorrect++;
        if(voiceControl == hero5Black.getVoiceControl())
            blackCorrect++;
        if(videoStabilization == hero5Black.getVideoStabilization())
            blackCorrect++;
        if(touch == hero5Black.getTouch())
            blackCorrect++;
        if(cloud == hero5Black.getCloud())
            blackCorrect++;
        if(location == hero5Black.getLocation())
            blackCorrect++;
        if(rarWdrPhotos == hero5Black.getRarWdrPhotos())
            blackCorrect++;

        int fSessionCorrect = 0;

        if(preferredMP == hero5Session.getMP())
            fSessionCorrect++;
        if(preferredFPS == hero5Session.getFPS())
            fSessionCorrect++;
        if(fourK == hero5Session.getFourK())
            fSessionCorrect++;
        if(voiceControl == hero5Session.getVoiceControl())
            fSessionCorrect++;
        if(videoStabilization == hero5Session.getVideoStabilization())
            fSessionCorrect++;
        if(touch == hero5Session.getTouch())
            fSessionCorrect++;
        if(cloud == hero5Session.getCloud())
            fSessionCorrect++;
        if(location == hero5Session.getLocation())
            fSessionCorrect++;
        if(rarWdrPhotos == hero5Session.getRarWdrPhotos())
            fSessionCorrect++;

        int sessionCorrect = 0;

        if(preferredMP == heroSession.getMP())
            sessionCorrect++;
        if(preferredFPS == heroSession.getFPS())
            sessionCorrect++;
        if(fourK == heroSession.getFourK())
            sessionCorrect++;
        if(voiceControl == heroSession.getVoiceControl())
            sessionCorrect++;
        if(videoStabilization == heroSession.getVideoStabilization())
            sessionCorrect++;
        if(touch == heroSession.getTouch())
            sessionCorrect++;
        if(cloud == heroSession.getCloud())
            sessionCorrect++;
        if(location == heroSession.getLocation())
            sessionCorrect++;
        if(rarWdrPhotos == heroSession.getRarWdrPhotos())
            sessionCorrect++;

        if(sessionCorrect > fSessionCorrect && sessionCorrect > blackCorrect)
            System.out.println("You should get the HERO Session. Go to http://shop.gopro.com/cameras for a list of features on all our cameras.");
        else if(fSessionCorrect > blackCorrect)
            System.out.println("You should get the HERO5 Session. Go to http://shop.gopro.com/cameras for a list of features on all our cameras.");
        else
            System.out.println("You should get the HERO5 Black. Go to http://shop.gopro.com/cameras for a list of features on all our cameras.");
    }

    public static boolean boolFeatures(String feature)
    {
        Scanner in = new Scanner(System.in);

        System.out.println(feature);
        String response = in.next();

        while(!response.equals("y") && !response.equals("n"))
        {
            System.out.println("Invalid response. Please enter either y or n");
            response = in.next();
        }

        if(response.equals("y"))
            return true;
        else
            return false;
    }
}
