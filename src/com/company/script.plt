set terminal pdf
set termoption enhanced
set datafile separator "\t"
set output "plotRemoves2.pdf"

set key left top

set xlabel "n"
set ylabel "time (ns)"


plot "data.dat" using 1:2 with linespoints title "array avg", \
     "data.dat" using 1:3 with linespoints title "array min", \
     "data.dat" using 1:4 with linespoints title "array worst case", \
     "data.dat" using 1:5 with linespoints title "linked avg", \
     "data.dat" using 1:6 with linespoints title "linked min", \
     "data.dat" using 1:7 with linespoints title "linked worst case"