//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package ai;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import map.MapS;

public class Aiv12 {
    private static final int DEPTH = 7;
    private static final int DEPTH_PATH = 12;
    private static final int MAXIMUM = 80000;
    private static final int MINIMUM = -80000;
    int[] priceofspace = new int[5];
    int amountnode;
    boolean crack = false;
    private boolean alphabeta = true;
    private static final int VAT = 5;
    private static final int VS = 1;
    private static final int KN = 31;
    private static final int KE = 11;

    public Aiv12() {
    }

    public int findDirection(MapS map, int x, int y, int xe, int ye) {
        if (!map.isSpace(x - 1, y) && !map.isSpace(x + 1, y) && !map.isSpace(x, y + 1) && !map.isSpace(x, y - 1)) {
            return -1;
        } else if (this.crack) {
            return this.findPathV1(map, x, y);
        } else if (!this.enemyInside(new MapS(map), xe, ye, x, y)) {
            this.crack = true;
            return this.findPathV1(map, x, y);
        } else {
            int t = this.minimax(map, x, y, xe, ye);
            if (t < 0) {
                if (map.isSpace(x - 1, y)) {
                    return 1;
                }

                if (map.isSpace(x + 1, y)) {
                    return 3;
                }

                if (map.isSpace(x, y - 1)) {
                    return 2;
                }

                if (map.isSpace(x, y + 1)) {
                    return 0;
                }
            }

            return t;
        }
    }

    private int findPathV1(MapS map, int x, int y) {
        int max = -1000;
        int dir = -1;
        MapS m;
        int temp;
        if (map.isSpace(x - 1, y)) {
            m = new MapS(map);
            m.setRed(x - 1, y);
            temp = this.searchPath(m, x - 1, y, 12);
            if (temp > max) {
                max = temp;
                dir = 1;
            }
        }

        if (map.isSpace(x + 1, y)) {
            m = new MapS(map);
            m.setRed(x + 1, y);
            temp = this.searchPath(m, x + 1, y, 12);
            if (temp > max) {
                max = temp;
                dir = 3;
            }
        }

        if (map.isSpace(x, y - 1)) {
            m = new MapS(map);
            m.setRed(x, y - 1);
            temp = this.searchPath(m, x, y - 1, 12);
            if (temp > max) {
                max = temp;
                dir = 2;
            }
        }

        if (map.isSpace(x, y + 1)) {
            m = new MapS(map);
            m.setRed(x, y + 1);
            temp = this.searchPath(m, x, y + 1, 12);
            if (temp > max) {
                dir = 0;
            }
        }

        return dir;
    }

    private int searchPath(MapS map, int x, int y, int depth) {
        int t = -999;
        if (depth <= 0) {
            return this.numberofegdes(map, x, y);
        } else {
            MapS m;
            int temp;
            if (map.isSpace(x - 1, y)) {
                m = new MapS(map);
                m.setRed(x - 1, y);
                temp = this.searchPath(m, x - 1, y, depth - 1);
                t = t > temp ? t : temp;
            }

            if (map.isSpace(x + 1, y)) {
                m = new MapS(map);
                m.setRed(x + 1, y);
                temp = this.searchPath(m, x + 1, y, depth - 1);
                t = t > temp ? t : temp;
            }

            if (map.isSpace(x, y - 1)) {
                m = new MapS(map);
                m.setRed(x, y - 1);
                temp = this.searchPath(m, x, y - 1, depth - 1);
                t = t > temp ? t : temp;
            }

            if (map.isSpace(x, y + 1)) {
                m = new MapS(map);
                m.setRed(x, y + 1);
                temp = this.searchPath(m, x, y + 1, depth - 1);
                t = t > temp ? t : temp;
            }

            return t < -990 ? -depth : t;
        }
    }

    private int countEdgesAStep(MapS map, ArrayList<Point> arp) {
        int count = 0;
        ArrayList temp = new ArrayList();

        while(!arp.isEmpty()) {
            Point p = (Point)arp.remove(0);
            int x = p.x;
            int y = p.y;
            if (map.isSpaceAndNotTemp(x + 1, y)) {
                count += map.amountSpacesAround(x + 1, y);
                temp.add(new Point(x + 1, y));
                map.setTemp(x + 1, y);
            }

            if (map.isSpaceAndNotTemp(x - 1, y)) {
                count += map.amountSpacesAround(x - 1, y);
                temp.add(new Point(x - 1, y));
                map.setTemp(x - 1, y);
            }

            if (map.isSpaceAndNotTemp(x, y + 1)) {
                count += map.amountSpacesAround(x, y + 1);
                temp.add(new Point(x, y + 1));
                map.setTemp(x, y + 1);
            }

            if (map.isSpaceAndNotTemp(x, y - 1)) {
                count += map.amountSpacesAround(x, y - 1);
                temp.add(new Point(x, y - 1));
                map.setTemp(x, y - 1);
            }
        }

        arp.addAll(temp);
        return count;
    }

    private int luonggiacanh(MapS map, int x, int y, int xe, int ye, boolean myturn) {
        int mysum = 0;
        int hissum = 0;
        ArrayList<Point> me = new ArrayList();
        ArrayList<Point> him = new ArrayList();
        me.add(new Point(x, y));
        him.add(new Point(xe, ye));
        if (myturn) {
            mysum += this.countEdgesAStep(map, me);
        }

        while(!me.isEmpty() || !him.isEmpty()) {
            hissum += this.countEdgesAStep(map, him);
            mysum += this.countEdgesAStep(map, me);
        }

        return mysum - hissum;
    }

    private int numberofegdes(MapS map, int x, int y) {
        int max = 0;
        ArrayList<Point> arp = new ArrayList();
        arp.add(new Point(x, y));
        int xs = x;
        int ys = y;
        Point p;
        byte t;
        int t;
        if (map.isSpaceAndNotTemp(x + 1, y)) {
            t = 0;
            t = t + map.amountSpacesAround(x + 1, y);
            map.setTemp(x + 1, y);
            arp.add(new Point(x + 1, y));

            while(!arp.isEmpty()) {
                p = (Point)arp.remove(0);
                xs = p.x;
                ys = p.y;
                if (map.isSpaceAndNotTemp(xs + 1, ys)) {
                    t += map.amountSpacesAround(xs + 1, ys);
                    map.setTemp(xs + 1, ys);
                    arp.add(new Point(xs + 1, ys));
                }

                if (map.isSpaceAndNotTemp(xs - 1, ys)) {
                    t += map.amountSpacesAround(xs - 1, ys);
                    map.setTemp(xs - 1, ys);
                    arp.add(new Point(xs - 1, ys));
                }

                if (map.isSpaceAndNotTemp(xs, ys + 1)) {
                    t += map.amountSpacesAround(xs, ys + 1);
                    map.setTemp(xs, ys + 1);
                    arp.add(new Point(xs, ys + 1));
                }

                if (map.isSpaceAndNotTemp(xs, ys - 1)) {
                    t += map.amountSpacesAround(xs, ys - 1);
                    map.setTemp(xs, ys - 1);
                    arp.add(new Point(xs, ys - 1));
                }
            }

            if (t > max) {
                max = t;
            }
        }

        if (map.isSpaceAndNotTemp(xs - 1, ys)) {
            t = 0;
            t = t + map.amountSpacesAround(xs - 1, ys);
            map.setTemp(xs - 1, ys);
            arp.add(new Point(xs - 1, ys));

            while(!arp.isEmpty()) {
                p = (Point)arp.remove(0);
                xs = p.x;
                ys = p.y;
                if (map.isSpaceAndNotTemp(xs + 1, ys)) {
                    t += map.amountSpacesAround(xs + 1, ys);
                    map.setTemp(xs + 1, ys);
                    arp.add(new Point(xs + 1, ys));
                }

                if (map.isSpaceAndNotTemp(xs - 1, ys)) {
                    t += map.amountSpacesAround(xs - 1, ys);
                    map.setTemp(xs - 1, ys);
                    arp.add(new Point(xs - 1, ys));
                }

                if (map.isSpaceAndNotTemp(xs, ys + 1)) {
                    t += map.amountSpacesAround(xs, ys + 1);
                    map.setTemp(xs, ys + 1);
                    arp.add(new Point(xs, ys + 1));
                }

                if (map.isSpaceAndNotTemp(xs, ys - 1)) {
                    t += map.amountSpacesAround(xs, ys - 1);
                    map.setTemp(xs, ys - 1);
                    arp.add(new Point(xs, ys - 1));
                }
            }

            if (t > max) {
                max = t;
            }
        }

        if (map.isSpaceAndNotTemp(xs, ys + 1)) {
            t = 0;
            t = t + map.amountSpacesAround(xs, ys + 1);
            map.setTemp(xs, ys + 1);
            arp.add(new Point(xs, ys + 1));

            while(!arp.isEmpty()) {
                p = (Point)arp.remove(0);
                xs = p.x;
                ys = p.y;
                if (map.isSpaceAndNotTemp(xs + 1, ys)) {
                    t += map.amountSpacesAround(xs + 1, ys);
                    map.setTemp(xs + 1, ys);
                    arp.add(new Point(xs + 1, ys));
                }

                if (map.isSpaceAndNotTemp(xs - 1, ys)) {
                    t += map.amountSpacesAround(xs - 1, ys);
                    map.setTemp(xs - 1, ys);
                    arp.add(new Point(xs - 1, ys));
                }

                if (map.isSpaceAndNotTemp(xs, ys + 1)) {
                    t += map.amountSpacesAround(xs, ys + 1);
                    map.setTemp(xs, ys + 1);
                    arp.add(new Point(xs, ys + 1));
                }

                if (map.isSpaceAndNotTemp(xs, ys - 1)) {
                    t += map.amountSpacesAround(xs, ys - 1);
                    map.setTemp(xs, ys - 1);
                    arp.add(new Point(xs, ys - 1));
                }
            }

            if (t > max) {
                max = t;
            }
        }

        if (map.isSpaceAndNotTemp(xs, ys - 1)) {
            t = 0;
            t = t + map.amountSpacesAround(xs, ys - 1);
            map.setTemp(xs, ys - 1);
            arp.add(new Point(xs, ys - 1));

            while(!arp.isEmpty()) {
                p = (Point)arp.remove(0);
                xs = p.x;
                ys = p.y;
                if (map.isSpaceAndNotTemp(xs + 1, ys)) {
                    t += map.amountSpacesAround(xs + 1, ys);
                    map.setTemp(xs + 1, ys);
                    arp.add(new Point(xs + 1, ys));
                }

                if (map.isSpaceAndNotTemp(xs - 1, ys)) {
                    t += map.amountSpacesAround(xs - 1, ys);
                    map.setTemp(xs - 1, ys);
                    arp.add(new Point(xs - 1, ys));
                }

                if (map.isSpaceAndNotTemp(xs, ys + 1)) {
                    t += map.amountSpacesAround(xs, ys + 1);
                    map.setTemp(xs, ys + 1);
                    arp.add(new Point(xs, ys + 1));
                }

                if (map.isSpaceAndNotTemp(xs, ys - 1)) {
                    t += map.amountSpacesAround(xs, ys - 1);
                    map.setTemp(xs, ys - 1);
                    arp.add(new Point(xs, ys - 1));
                }
            }

            if (t > max) {
                max = t;
            }
        }

        return max;
    }

    public int minimax(MapS map, int x, int y, int xe, int ye) {
        int depth = 14;
        int direction = -1;
        int value = -80000;
        int alpha = -80000;
        int beta = 80000;
        this.amountnode = 0;
        MapS maptemp;
        int temp;
        if (map.isSpace(x, y + 1)) {
            maptemp = new MapS(map);
            maptemp.setRed(x, y + 1);
            temp = this.minValue(maptemp, x, y + 1, xe, ye, depth - 1, alpha, beta);
            if (temp > value) {
                value = temp;
                direction = 0;
            }
        }

        if (map.isSpace(x, y - 1)) {
            maptemp = new MapS(map);
            maptemp.setRed(x, y - 1);
            temp = this.minValue(maptemp, x, y - 1, xe, ye, depth - 1, alpha, beta);
            if (temp > value) {
                value = temp;
                direction = 2;
            }
        }

        if (map.isSpace(x + 1, y)) {
            maptemp = new MapS(map);
            maptemp.setRed(x + 1, y);
            temp = this.minValue(maptemp, x + 1, y, xe, ye, depth - 1, alpha, beta);
            if (temp > value) {
                value = temp;
                direction = 3;
            }
        }

        if (map.isSpace(x - 1, y)) {
            maptemp = new MapS(map);
            maptemp.setRed(x - 1, y);
            temp = this.minValue(maptemp, x - 1, y, xe, ye, depth - 1, alpha, beta);
            if (temp > value) {
                value = temp;
                direction = 1;
            }
        }

        System.out.println("V12: " + value);
        return direction;
    }

    private int maxValue(MapS map, int x, int y, int xe, int ye, int depth, int alpha, int beta) {
        ++this.amountnode;
        int max = -80000;
        int temp;
        if (!this.crack && !this.enemyInside(map, xe, ye, x, y)) {
            temp = 31 * this.luonggiaOutside(new MapS(map), x, y, xe, ye) + 11 * this.luonggiacanh(new MapS(map), x, y, xe, ye, true);
            return temp <= 1 && temp >= -1 ? temp : temp * 5;
        } else {
            if (depth > 0) {
                MapS maptemp;
                if (map.isSpace(x + 1, y)) {
                    maptemp = new MapS(map);
                    maptemp.setRed(x + 1, y);
                    temp = this.minValue(maptemp, x + 1, y, xe, ye, depth - 1, alpha, beta);
                    if (temp > max) {
                        max = temp;
                    }

                    if (this.alphabeta) {
                        if (max >= beta) {
                            return max;
                        }

                        if (alpha < max) {
                            alpha = max;
                        }
                    }
                }

                if (map.isSpace(x - 1, y)) {
                    maptemp = new MapS(map);
                    maptemp.setRed(x - 1, y);
                    temp = this.minValue(maptemp, x - 1, y, xe, ye, depth - 1, alpha, beta);
                    if (temp > max) {
                        max = temp;
                    }

                    if (this.alphabeta) {
                        if (max >= beta) {
                            return max;
                        }

                        if (alpha < max) {
                            alpha = max;
                        }
                    }
                }

                if (map.isSpace(x, y + 1)) {
                    maptemp = new MapS(map);
                    maptemp.setRed(x, y + 1);
                    temp = this.minValue(maptemp, x, y + 1, xe, ye, depth - 1, alpha, beta);
                    if (temp > max) {
                        max = temp;
                    }

                    if (this.alphabeta) {
                        if (max >= beta) {
                            return max;
                        }

                        if (alpha < max) {
                            alpha = max;
                        }
                    }
                }

                if (map.isSpace(x, y - 1)) {
                    maptemp = new MapS(map);
                    maptemp.setRed(x, y - 1);
                    temp = this.minValue(maptemp, x, y - 1, xe, ye, depth - 1, alpha, beta);
                    if (temp > max) {
                        max = temp;
                    }

                    if (this.alphabeta) {
                        if (max >= beta) {
                            return max;
                        }

                        if (alpha < max) {
                            ;
                        }
                    }
                }
            } else {
                max = 31 * this.luonggia(new MapS(map), x, y, xe, ye, true) + 11 * this.luonggiacanh(new MapS(map), x, y, xe, ye, true);
            }

            if (max == -80000) {
                max = -40000 - depth;
            }

            return max;
        }
    }

    private int minValue(MapS map, int x, int y, int xe, int ye, int depth, int alpha, int beta) {
        ++this.amountnode;
        int min = 80000;
        int temp;
        if (!this.crack && !this.enemyInside(map, xe, ye, x, y)) {
            temp = 31 * this.luonggiaOutside(new MapS(map), x, y, xe, ye) + 11 * this.luonggiacanh(new MapS(map), x, y, xe, ye, false);
            return temp <= 1 && temp >= -1 ? temp : temp * 5;
        } else {
            MapS maptemp;
            if (map.isSpace(xe + 1, ye)) {
                maptemp = new MapS(map);
                maptemp.setGreen(xe + 1, ye);
                temp = this.maxValue(maptemp, x, y, xe + 1, ye, depth - 1, alpha, beta);
                if (temp < min) {
                    min = temp;
                }

                if (this.alphabeta) {
                    if (min <= alpha) {
                        return min;
                    }

                    beta = beta < min ? beta : min;
                }
            }

            if (map.isSpace(xe - 1, ye)) {
                maptemp = new MapS(map);
                maptemp.setGreen(xe - 1, ye);
                temp = this.maxValue(maptemp, x, y, xe - 1, ye, depth - 1, alpha, beta);
                if (temp < min) {
                    min = temp;
                }

                if (this.alphabeta) {
                    if (min <= alpha) {
                        return min;
                    }

                    beta = beta < min ? beta : min;
                }
            }

            if (map.isSpace(xe, ye + 1)) {
                maptemp = new MapS(map);
                maptemp.setGreen(xe, ye + 1);
                temp = this.maxValue(maptemp, x, y, xe, ye + 1, depth - 1, alpha, beta);
                if (temp < min) {
                    min = temp;
                }

                if (this.alphabeta) {
                    if (min <= alpha) {
                        return min;
                    }

                    beta = beta < min ? beta : min;
                }
            }

            if (map.isSpace(xe, ye - 1)) {
                maptemp = new MapS(map);
                maptemp.setGreen(xe, ye - 1);
                temp = this.maxValue(maptemp, x, y, xe, ye - 1, depth - 1, alpha, beta);
                if (temp < min) {
                    min = temp;
                }

                if (this.alphabeta) {
                    if (min <= alpha) {
                        return min;
                    }

                    beta = beta < min ? beta : min;
                }
            }

            if (min == 80000) {
                min = '鱀' + depth;
            }

            return min;
        }
    }

    private int luonggiaOutside(MapS m, int x, int y, int xe, int ye) {
        int mysum = false;
        int hissum = false;
        int black = 0;
        int white = 0;
        ArrayList<Point> arp = new ArrayList();
        arp.add(new Point(x, y));
        boolean blackturn = true;

        while(!arp.isEmpty()) {
            if (blackturn) {
                black += this.redGo(arp, m);
                blackturn = false;
            } else {
                white += this.redGo(arp, m);
                blackturn = true;
            }
        }

        int mysum = white + black;
        if (white > black) {
            mysum -= white - black;
        } else if (white < black - 1) {
            mysum -= black - 1 - white;
        }

        white = 0;
        black = 0;
        arp.add(new Point(xe, ye));
        blackturn = true;

        while(!arp.isEmpty()) {
            if (blackturn) {
                black += this.redGo(arp, m);
                blackturn = false;
            } else {
                white += this.redGo(arp, m);
                blackturn = true;
            }
        }

        int hissum = white + black;
        if (hissum <= 0) {
            if (white > black) {
                hissum -= white - black;
            } else if (white < black - 1) {
                hissum -= black - 1 - white;
            }
        }

        return mysum - hissum;
    }

    public int luonggia(MapS map, int x, int y, int xe, int ye, boolean ismyturn) {
        ArrayList<Point> red = new ArrayList();
        ArrayList<Point> green = new ArrayList();
        red.add(new Point(x, y));
        green.add(new Point(xe, ye));
        int sumred = 0;
        int sumgreen = 0;
        if (!this.crack) {
            if (ismyturn) {
                while(!red.isEmpty() || !green.isEmpty()) {
                    sumred += this.redGo(red, map);
                    sumgreen += this.greenGo(green, map);
                }
            } else {
                while(!red.isEmpty() || !green.isEmpty()) {
                    sumgreen += this.greenGo(green, map);
                    sumred += this.redGo(red, map);
                }
            }
        } else {
            while(!red.isEmpty()) {
                sumred += this.redGo(red, map);
            }
        }

        return sumred - sumgreen;
    }

    private int redGo(ArrayList<Point> red, MapS map) {
        ArrayList<Point> redtemp = new ArrayList();

        int sumred;
        for(sumred = 0; !red.isEmpty(); red.remove(0)) {
            Point point = (Point)red.get(0);
            int x = point.x;
            int y = point.y;
            if (map.isSpace(x + 1, y)) {
                ++sumred;
                map.setRed(x + 1, y);
                redtemp.add(new Point(x + 1, y));
            }

            if (map.isSpace(x - 1, y)) {
                ++sumred;
                map.setRed(x - 1, y);
                redtemp.add(new Point(x - 1, y));
            }

            if (map.isSpace(x, y + 1)) {
                ++sumred;
                map.setRed(x, y + 1);
                redtemp.add(new Point(x, y + 1));
            }

            if (map.isSpace(x, y - 1)) {
                ++sumred;
                map.setRed(x, y - 1);
                redtemp.add(new Point(x, y - 1));
            }
        }

        for(int i = 0; i < redtemp.size(); ++i) {
            red.add((Point)redtemp.get(i));
        }

        return sumred;
    }

    private int greenGo(ArrayList<Point> green, MapS map) {
        ArrayList<Point> greentemp = new ArrayList();

        int sumgreen;
        for(sumgreen = 0; !green.isEmpty(); green.remove(0)) {
            Point point = (Point)green.get(0);
            int x = point.x;
            int y = point.y;
            if (map.isSpace(x + 1, y)) {
                ++sumgreen;
                map.setGreen(x + 1, y);
                greentemp.add(new Point(x + 1, y));
            }

            if (map.isSpace(x - 1, y)) {
                ++sumgreen;
                map.setGreen(x - 1, y);
                greentemp.add(new Point(x - 1, y));
            }

            if (map.isSpace(x, y + 1)) {
                ++sumgreen;
                map.setGreen(x, y + 1);
                greentemp.add(new Point(x, y + 1));
            }

            if (map.isSpace(x, y - 1)) {
                ++sumgreen;
                map.setGreen(x, y - 1);
                greentemp.add(new Point(x, y - 1));
            }
        }

        for(int i = 0; i < greentemp.size(); ++i) {
            green.add((Point)greentemp.get(i));
        }

        return sumgreen;
    }

    private boolean enemyInside(MapS m, int xg, int yg, int xr, int yr) {
        MapS map = new MapS(m);
        Queue<Point> queue = new LinkedList();
        queue.add(new Point(xr, yr));

        while(!queue.isEmpty()) {
            Point element = (Point)queue.remove();
            int x = element.x;
            int y = element.y;
            if (map.isSpace(x + 1, y)) {
                map.setMap(x + 1, y);
                queue.add(new Point(x + 1, y));
            }

            if (map.isSpace(x - 1, y)) {
                map.setMap(x - 1, y);
                queue.add(new Point(x - 1, y));
            }

            if (map.isSpace(x, y - 1)) {
                map.setMap(x, y - 1);
                queue.add(new Point(x, y - 1));
            }

            if (map.isSpace(x, y + 1)) {
                map.setMap(x, y + 1);
                queue.add(new Point(x, y + 1));
            }
        }

        if (!map.isReachable(xg + 1, yg) && !map.isReachable(xg - 1, yg) && !map.isReachable(xg, yg + 1) && !map.isReachable(xg, yg - 1)) {
            return false;
        } else {
            return true;
        }
    }
}
