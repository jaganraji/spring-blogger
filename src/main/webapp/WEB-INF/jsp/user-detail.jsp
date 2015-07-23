<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>



<%@ include file="../layout/taglib.jsp"%>

<h1>${user.name}</h1>


<br>
<br>

<script type="text/javascript">
	$(document).ready(function() {
		$('.nav-tabs a:first').tab('show')
	});
</script>
<div>

	<!-- Nav tabs -->
	<ul class="nav nav-tabs" role="tablist">
		<c:forEach items="${user.blogs}" var="blog">
			<li role="presentation"><a href="##blog_${blog.id}"
				aria-controls="blog_${blog.id}" role="tab" data-toggle="tab">${blog.name}</a></li>
		</c:forEach>

	</ul>

	<!-- Tab panes -->
	<div class="tab-content">
		<c:forEach items="${user.blogs}" var="blog">
			<div role="tabpanel" class="tab-pane" id="blog_${blog.id}">
				<h1>${blog.name}</h1>
				<p>
				<a href="<spring:url value="/blog/remove/${blog.id}.html" />" class="btn btn-danger">Remove blog</a>
				 </p>
				<h1>${blog.url}</h1>

				<table class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th>Title</th>
							<th>Link</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${blog.items}" var="item">
							<tr>
								<td>${item.title}</td>
								<td>${item.link}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</c:forEach>
	</div>

</div>

