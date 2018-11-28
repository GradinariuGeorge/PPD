package practic;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Graph graph=new Graph();
        List<Muchie> muchies=CSVReader.getMuchii();
//        for (Muchie muchie: muchies
//             ) {
//            System.out.println(muchie.toString());
//        }
        Thread insert1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    for (int i=0;i<muchies.size()/2;i++) {
                        try {
                            Muchie muchie= muchies.get(i);
                            graph.inserMuchie(muchie.getNode1(),muchie.getNode2());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                    Thread.currentThread().interrupt();
                }
            }
        });
        Thread insert2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    for (Muchie muchie:muchies
                    ) {
                        for (int i=muchies.size()/2;i<muchies.size();i++) {
                            try {
                                Muchie muchie1 = muchies.get(i);
                                graph.inserMuchie(muchie1.getNode1(), muchie1.getNode2());
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }

                    }
                    Thread.currentThread().interrupt();
                }
            }
        });
        insert1.start();
        insert2.start();

        Thread iterate = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {
                        graph.iterate();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        iterate.start();

        try {
            insert1.join();
            insert2.join();
            iterate.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
