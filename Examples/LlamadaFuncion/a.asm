{0} ssp 1;
{1} mst 0;
{2} cup 0 4;
{3} stp;
{4} ssp 6;
{5} lda 0 5;
{6} mst 1;
{7} ldc 2;
{8} ldc 10;
{9} cup 2 15;
{10} sto;
{11} lda 0 5;
{12} ind;
{13} str 0 0;
{14} retf;
{15} ssp 9;
{16} lda 0 6;
{17} ind;
{18} ldc 0;
{19} equ;
{20} fjp 25;
{21} lda 0 7;
{22} ldc 1;
{23} sto;
{24} ujp 60;
{25} lda 0 8;
{26} lda 0 6;
{27} ind;
{28} ldc 2;
{29} div;
{30} sto;
{31} lda 0 7;
{32} mst 1;
{33} lda 0 5;
{34} ind;
{35} lda 0 8;
{36} ind;
{37} cup 2 15;
{38} sto;
{39} lda 0 7;
{40} lda 0 7;
{41} ind;
{42} lda 0 7;
{43} ind;
{44} mul;
{45} sto;
{46} lda 0 6;
{47} ind;
{48} ldc 2;
{49} mod;
{50} ldc 1;
{51} equ;
{52} fjp 60;
{53} lda 0 7;
{54} lda 0 7;
{55} ind;
{56} lda 0 5;
{57} ind;
{58} mul;
{59} sto;
{60} lda 0 7;
{61} ind;
{62} str 0 0;
{63} retf;
