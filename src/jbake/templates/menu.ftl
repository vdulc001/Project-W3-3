<div class="leftPart">
  <div class="menuBlock">
    <span class="menuBlockHeader"><a href="<#if
										   (content.rootpath)??>${content.rootpath}<#else></#if>home.html">Home</a></span>
  </div>
  <div class="menuBlock">
    <span class="menuBlockHeader">Project Info</span>
	<ul>
      <li><a href="<#if (content.rootpath)??>${content.rootpath}<#else></#if>javadoc/index.html">API (Javadoc)</a></li>
      <li><a href="<#if (content.rootpath)??>${content.rootpath}<#else></#if>tests/test/index.html>UnitTest (Junit)</a></li>
      <li><a href="<#if (content.rootpath)??>${content.rootpath}<#else></#if>dependencies.html">Dependencies</a></li>
      <li><a href="<#if (content.rootpath)??>${content.rootpath}<#else></#if>spotbugs/main.html">SpotCheck (Static Analysis)</a></li>
      
	</ul>
  </div>
  <div class="menuBlock">
    <span class="menuBlockHeader">Testing</span>
	<ul>
      <li><a href="<#if
      (content.rootpath)??>${content.rootpath}<#else></#if>junit.html">Unit
		  Tests</a></li>
	  <!--
      <li><a href="<#if
		(content.rootpath)??>${content.rootpath}<#else></#if>jacoco.html">Coverage</a></li>
-->
	</ul>
  </div>
  <!--
  <div class="menuBlock">
 	<span class="menuBlockHeader">Analysis Reports</span>
	<ul>
      <li><a href="<#if (content.rootpath)??>${content.rootpath}<#else></#if>checkstyle.html">Checkstyle</a></li>
      <li><a href="<#if (content.rootpath)??>${content.rootpath}<#else></#if>dependencies.html">Dependencies</a></li>
	</ul>
  </div>
-->
</div>