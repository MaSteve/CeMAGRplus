{0} ssp 1;
{1} mst 0;
{2} cup 0 4;
{3} stp;
{ FUNC main }
{4} ssp 8;
{ €a }
{5} lda 0 5;
{ := }
{6} ldc 10;
{ cte: 10 }
{7} sto;
{ €b }
{8} lda 0 6;
{ := }
{9} ldc 20;
{ cte: 20 }
{10} sto;
{ €ret }
{11} lda 0 7;
{ := }
{ call: funcion }
{12} mst 1;
{ €a }
{13} lda 0 5;
{ €b }
{14} lda 0 6;
{15} cup 2 21;
{16} sto;
{ €ret }
{17} lda 0 7;
{18} ind;
{19} str 0 0;
{ RETURN }
{20} retf;
{ END FUNC }
{ FUNC funcion }
{21} ssp 7;
{ €n }
{22} lda 0 5;
{23} ind;
{ := }
{ €n }
{24} lda 0 5;
{25} ind;
{26} ind;
{27} ldc 2;
{ cte: 2 }
{28} add;
{ + }
{29} sto;
{ €m }
{30} lda 0 6;
{31} ind;
{ := }
{ €m }
{32} lda 0 6;
{33} ind;
{34} ind;
{35} ldc 5;
{ cte: 5 }
{36} sub;
{ - }
{37} sto;
{ €n }
{38} lda 0 5;
{39} ind;
{40} ind;
{ €m }
{41} lda 0 6;
{42} ind;
{43} ind;
{44} add;
{ + }
{45} str 0 0;
{ RETURN }
{46} retf;
{ END FUNC }
