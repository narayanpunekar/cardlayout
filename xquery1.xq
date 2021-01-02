for $xquery3 in doc('ProductBacklog.xml')/ProductBacklog 
return 
<Data>
<LastCnt>{max($xquery3/SNo/@cnt)}</LastCnt> 
<SolvedCnt>{count($xquery3/SNo[SolutionDescription])}</SolvedCnt> 
<SolNum>{count($xquery3//SolutionDescription)}</SolNum> 
</Data> 
