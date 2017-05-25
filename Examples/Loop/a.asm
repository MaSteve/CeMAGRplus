{0} ssp 1;
{1} mst 0;
{2} cup 0 4;
{3} stp;
{ FUNC main }
{4} ssp 18;
{ €suma }
{5} lda 0 17;
{ := }
{6} ldc 0;
{ cte: 0 }
{7} sto;
{ €n }
{8} lda 0 16;
{ := }
{9} ldc 10;
{ cte: 10 }
{10} sto;
{ €cont }
{11} lda 0 15;
{ := }
{12} ldc 0;
{ cte: 0 }
{13} sto;
{ WHILE }
{ €cont }
{14} lda 0 15;
{15} ind;
{ €n }
{16} lda 0 16;
{17} ind;
{18} les;
{ < }
{19} fjp 31;
{ DO }
{ €array }
{20} lda 0 5;
{ €cont }
{21} lda 0 15;
{22} ind;
{23} chk 0 10;
{24} ixa 1;
{[idx]}
{ := }
{ €cont }
{25} lda 0 15;
{26} ind;
{27} ldc 1;
{ cte: 1 }
{28} add;
{ + }
{29} sto;
{30} ujp 14;
{ END WHILE }
{ €cont }
{31} lda 0 15;
{ := }
{32} ldc 0;
{ cte: 0 }
{33} sto;
{ WHILE }
{ €cont }
{34} lda 0 15;
{35} ind;
{ €n }
{36} lda 0 16;
{37} ind;
{38} les;
{ < }
{39} fjp 58;
{ DO }
{ €suma }
{40} lda 0 17;
{ := }
{ €suma }
{41} lda 0 17;
{42} ind;
{ €array }
{43} lda 0 5;
{ €cont }
{44} lda 0 15;
{45} ind;
{46} chk 0 10;
{47} ixa 1;
{[idx]}
{48} ind;
{49} add;
{ + }
{50} sto;
{ €cont }
{51} lda 0 15;
{ := }
{ €cont }
{52} lda 0 15;
{53} ind;
{54} ldc 1;
{ cte: 1 }
{55} add;
{ + }
{56} sto;
{57} ujp 34;
{ END WHILE }
{58} ldc 0;
{ cte: 0 }
{59} str 0 0;
{ RETURN }
{60} retf;
{ END FUNC }
