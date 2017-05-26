{0} ssp 1;
{1} mst 0;
{2} cup 0 4;
{3} stp;
{ FUNC main }
{4} ssp 6;
{ $ret }
{5} lda 0 5;
{ := }
{ call: pot }
{6} mst 1;
{7} ldc 2;
{ cte: 2 }
{8} ldc 10;
{ cte: 10 }
{9} cup 2 15;
{10} sto;
{ $ret }
{11} lda 0 5;
{12} ind;
{13} str 0 0;
{ RETURN }
{14} retf;
{ END FUNC }
{ FUNC pot }
{15} ssp 9;
{ IF }
{ $p }
{16} lda 0 6;
{17} ind;
{18} ldc 0;
{ cte: 0 }
{19} equ;
{ == }
{20} fjp 25;
{ THEN }
{ $ret }
{21} lda 0 7;
{ := }
{22} ldc 1;
{ cte: 1 }
{23} sto;
{24} ujp 60;
{ ELSE }
{ $np }
{25} lda 0 8;
{ := }
{ $p }
{26} lda 0 6;
{27} ind;
{28} ldc 2;
{ cte: 2 }
{29} div;
{ / }
{30} sto;
{ $ret }
{31} lda 0 7;
{ := }
{ call: pot }
{32} mst 1;
{ $n }
{33} lda 0 5;
{34} ind;
{ $np }
{35} lda 0 8;
{36} ind;
{37} cup 2 15;
{38} sto;
{ $ret }
{39} lda 0 7;
{ := }
{ $ret }
{40} lda 0 7;
{41} ind;
{ $ret }
{42} lda 0 7;
{43} ind;
{44} mul;
{ * }
{45} sto;
{ IF }
{ $p }
{46} lda 0 6;
{47} ind;
{48} ldc 2;
{ cte: 2 }
{49} mod;
{ % }
{50} ldc 1;
{ cte: 1 }
{51} equ;
{ == }
{52} fjp 60;
{ THEN }
{ $ret }
{53} lda 0 7;
{ := }
{ $ret }
{54} lda 0 7;
{55} ind;
{ $n }
{56} lda 0 5;
{57} ind;
{58} mul;
{ * }
{59} sto;
{ END IF }
{ END IF }
{ $ret }
{60} lda 0 7;
{61} ind;
{62} str 0 0;
{ RETURN }
{63} retf;
{ END FUNC }
