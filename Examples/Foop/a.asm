{0} ssp 1;
{1} mst 0;
{2} cup 0 4;
{3} stp;
{ FUNC main }
{4} ssp 18;
{ $suma }
{5} lda 0 17;
{ := }
{6} ldc 0;
{ cte: 0 }
{7} sto;
{ $n }
{8} lda 0 16;
{ := }
{9} ldc 10;
{ cte: 10 }
{10} sto;
{ FOR }
{ $cont }
{11} lda 0 15;
{ := }
{12} ldc 0;
{ cte: 0 }
{13} sto;
{ $cont }
{14} lda 0 15;
{15} ind;
{ $n }
{16} lda 0 16;
{17} ind;
{18} les;
{ < }
{19} fjp 37;
{ DO }
{ $array }
{20} lda 0 5;
{ $cont }
{21} lda 0 15;
{22} ind;
{23} chk 0 10;
{24} ixa 1;
{[idx]}
{ := }
{ $cont }
{25} lda 0 15;
{26} ind;
{27} ldc 1;
{ cte: 1 }
{28} add;
{ + }
{29} sto;
{ $cont }
{30} lda 0 15;
{ := }
{ $cont }
{31} lda 0 15;
{32} ind;
{33} ldc 1;
{ cte: 1 }
{34} add;
{ + }
{35} sto;
{36} ujp 14;
{ END FOR }
{ FOR }
{ $cont }
{37} lda 0 15;
{ := }
{38} ldc 0;
{ cte: 0 }
{39} sto;
{ $cont }
{40} lda 0 15;
{41} ind;
{ $n }
{42} lda 0 16;
{43} ind;
{44} les;
{ < }
{45} fjp 64;
{ DO }
{ $suma }
{46} lda 0 17;
{ := }
{ $suma }
{47} lda 0 17;
{48} ind;
{ $array }
{49} lda 0 5;
{ $cont }
{50} lda 0 15;
{51} ind;
{52} chk 0 10;
{53} ixa 1;
{[idx]}
{54} ind;
{55} add;
{ + }
{56} sto;
{ $cont }
{57} lda 0 15;
{ := }
{ $cont }
{58} lda 0 15;
{59} ind;
{60} ldc 1;
{ cte: 1 }
{61} add;
{ + }
{62} sto;
{63} ujp 40;
{ END FOR }
{64} ldc 0;
{ cte: 0 }
{65} str 0 0;
{ RETURN }
{66} retf;
{ END FUNC }
