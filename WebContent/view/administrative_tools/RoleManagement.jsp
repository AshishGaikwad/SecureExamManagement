<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="../impl/_header.jsp"%>
<body id="create_screen">

	<div class="row">
		<div class="col-md-12">
			<div class="panel-group" id="accordion">
				<div class="panel panel-accordion">
					<div class="panel-heading">
						<h4 class="panel-title">
							<a class="accordion-toggle" data-toggle="collapse"
								data-parent="#accordion" href="#CreateUserAcco">Create Role</a>
						</h4>
					</div>
					<div id="CreateUserAcco" class="accordion-body collapse in">
						<div class="panel-body">
							<div class="col-lg-12">
								<div class="form-group">
									<label class="col-md-3 control-label" for="inputDefault">Role
										Name</label>
									<div class="col-md-6">
										<select class="form-control input-sm mb-md" id="RoleName">
											<option value="0">--Select Role--</option>
										</select>
									</div>
								</div>
								<table id="RoleMappingTable" class="table table-bordered table-striped mb-none">
									<thead>
										<tr>
											<th>Select</th>
											<th>Screen Id</th>
											<th>Screen Name</th>
											<th>Read</th>
											<th>Write</th>
											<th>Update</th>
											<th>Delete</th>
										</tr>
									</thead>
									<tbody>
									<tr>
											<td>Select</td>
											<td>Screen Id</td>
											<td>Screen Name</td>
											<td>Read</td>
											<td>Write</td>
											<td>Update</td>
											<td>Delete</td>
											</tr>
									</tbody>
								</table>
								<br><br>
								<div class="form-group">
									<button id="CreateScreenButton" class="btn btn-block btn-primary">Create Screen</button>
								</div>

							</div>


						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<%@ include file="../impl/_vendor.jsp"%>
<script src="<%=request.getContextPath()%>/res/js/impl/role-management.js"></script>
</html>