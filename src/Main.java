import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = null;
    private static UnTar unTar;
    static String destination;

    public static void main(String[] args) throws IOException {
        scanner = new Scanner(System.in);
        System.out.println("whats the path?");
        String input = scanner.nextLine();
        System.out.println("where to extract it to:");
        destination = scanner.nextLine();

        String TAR_FOLDER = destination;

        UnTar unTar = new UnTar();

        File inputFile = new File(input);

        String outputFile = unTar.getFileName(inputFile, TAR_FOLDER);

        System.out.println("outputFile: " + outputFile);

        File tarFile = new File(outputFile);

        tarFile = unTar.deCompressGZipFile(inputFile, tarFile);
        File destFile = new File(destination);
        if(!destFile.exists()){
            destFile.mkdir();
        }

        // Calling method to untar file
        unTar.unTarFile(tarFile, destFile);

