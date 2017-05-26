{0} ssp 1;
{1} mst 0;
{2} cup 0 4;
{3} stp;
{ FUNC main }
{4} ssp 6;
{ $ret }
{5} lda 0 5;
{ := }
{ call: test }
{6} mst 1;
{7} ldc 7;
{ cte: 7 }
{8} cup 1 14;
{9} sto;
{ $ret }
{10} lda 0 5;
{11} ind;
{12} str 0 0;
{ RETURN }
{13} retf;
{ END FUNC }
{ FUNC test }
{14} ssp 8;
{ SWITCH }
{ $n }
{15} lda 0 5;
{16} ind;
{17} dpl;
{18} ldc 1;
{19} geq;
{20} fjp 49;
{21} dpl;
{22} ldc 5;
{23} leq;
{24} fjp 49;
{25} ldc 1;
{26} sub;
{27} neg;
{28} ixj 58;
{ CASE 1 }
{ $ret }
{29} lda 0 6;
{ := }
{30} ldc 10;
{ cte: 10 }
{31} sto;
{32} ujp 59;
{ CASE 2 }
{ $auxi }
{33} lda 0 7;
{ := }
{34} ldc 5;
{ cte: 5 }
{35} sto;
{ $ret }
{36} lda 0 6;
{ := }
{ $auxi }
{37} lda 0 7;
{38} ind;
{ $auxi }
{39} lda 0 7;
{40} ind;
{41} mul;
{ * }
{42} sto;
{43} ujp 59;
{ CASE 5 }
{ $ret }
{44} lda 0 6;
{ := }
{45} ldc 2;
{ cte: 2 }
{46} neg;
{ - }
{47} sto;
{48} ujp 59;
{ DEFAULT }
{ $ret }
{49} lda 0 6;
{ := }
{50} ldc 500;
{ cte: 500 }
{51} neg;
{ - }
{52} sto;
{53} ujp 59;
{54} ujp 44;
{55} ujp 49;
{56} ujp 49;
{57} ujp 33;
{58} ujp 29;
{ END SWITCH }
{ $ret }
{59} lda 0 6;
{60} ind;
{61} str 0 0;
{ RETURN }
{62} retf;
{ END FUNC }
