package Zad12;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class LogSystem<T extends ILog & Comparable<T>> {
        //TODO add instance variable(s)
        ArrayList<T> logsList;
        //TODO constructor


        public LogSystem(ArrayList<T> logsList) {
                this.logsList = logsList;
        }

        void printResults() {

        //TODO define concrete log processors with lambda expressions
        LogProcessor<T> firstLogProcessor = logs -> logs.stream()
                                                    .filter(log -> log.getType().equals("INFO"))
                                                    .collect(Collectors.toCollection(ArrayList::new));

        LogProcessor<T> secondLogProcessor = logs -> logs.stream()
                                                    .filter(log -> log.getMessage().length()<100)
                                                    .collect(Collectors.toCollection(ArrayList::new));

        LogProcessor<T> thirdLogProcessor = logs -> logs.stream().sorted()
                                                        .collect(Collectors.toCollection(ArrayList::new));

        System.out.println("RESULTS FROM THE FIRST LOG PROCESSOR");
        firstLogProcessor.processLogs(logsList).forEach(l -> System.out.println(l.toString()));

        System.out.println("RESULTS FROM THE SECOND LOG PROCESSOR");
        secondLogProcessor.processLogs(logsList).forEach(l -> System.out.println(l.toString()));

        System.out.println("RESULTS FROM THE THIRD LOG PROCESSOR");
        thirdLogProcessor.processLogs(logsList).forEach(l -> System.out.println(l.toString()));
        }
        }
