package com.qinergy.util;

import java.util.Random;

/**
 * Created by cj on 2017/10/2 0002.
 */
public class GenerateDataUtils {


    public static void main(String[] args) {


        testPower();



    }

    private static void testPower() {
        StringBuilder sb = new StringBuilder();
        Double udc;
        for (int i = 0; i < 24; i++) {

            udc = generatePower(i, 0, 33.17);
            sb.append(udc).append("\r\n");
        }

        System.out.println(sb.toString());
    }




    public static Double generateU(int hour, Double cha_elc) {
        Random random = new Random();
        return cha_elc   + random.nextInt(15)+ random.nextDouble();

    }


    /**
     * 实时发电量
     * @return
     */
    public static Double generatePower(Integer hour, int minute, Double day_p) {
        Random random = new Random();
        Double percent = 0.0;
        switch (hour){
            case 6:
                percent = 0.01;
                break;
            case 7:
                percent = 0.04;
                break;
            case 8:
                percent = 0.05;
                break;
            case 9:
                percent = 0.11;
                break;
            case 10:
                percent = 0.12;
                break;
            case 11:
                percent = 0.13;
                break;
            case 12:
                percent = 0.13;
                break;
            case 13:
                percent = 0.12;
                break;
            case 14:
                percent = 0.11;
                break;
            case 15:
                percent = 0.07;
                break;
            case 16:
                percent = 0.05;
                break;
            case 17:
                percent = 0.05;
                break;
            case 18:
                percent = 0.01;
                break;
            default:
                percent = 0.0;
                break;
        }
        // 每30秒
        return day_p * percent  + random.nextInt(1)+ random.nextDouble();
    }


    public static void testP() {
        // height_angle=25 ， azimuth=3   最佳倾角 25°，
//        System.out.println( getBeijingTemp() );

        StringBuilder sb = new StringBuilder();


        Double udc;
        Double[] udcs = new Double[12 * 4];
        for (int i = 0; i < 24; i++) {

            for (int j = 0; j < 4; j++) {

                int minute = j *15;

                udc = generateP(i, minute, 1.2);

                udcs[i] = udc;

                sb.append(udc).append("\r\n");
            }
        }

        System.out.println(sb.toString());

    }

    public static Double generateP(Integer hour, int minute, Double day_p) {

        Random random = new Random();
        Double percent = 0.0;
        switch (hour){
            case 6:
                percent = 0.01;
                break;
            case 7:
                percent = 0.04;
                break;
            case 8:
                percent = 0.05;
                break;
            case 9:
                percent = 0.11;
                break;
            case 10:
                percent = 0.12;
                break;
            case 11:
                percent = 0.13;
                break;
            case 12:
                percent = 0.13;
                break;
            case 13:
                percent = 0.12;
                break;
            case 14:
                percent = 0.11;
                break;
            case 15:
                percent = 0.07;
                break;
            case 16:
                percent = 0.05;
                break;
            case 17:
                percent = 0.05;
                break;
            case 18:
                percent = 0.01;
                break;
            default:
                percent = 0.0;
                break;
        }

        // kw -> w (day_p * 1000)
        return day_p * 1000 * percent  + random.nextInt(1)*100+ random.nextDouble();

    }

}
