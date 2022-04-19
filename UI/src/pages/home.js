import { useState,useEffect } from "react";
import http from "../http"
import { Link } from "react-router-dom";
export default function Home() {
    const [employees, setEmployees] = useState([]);

    useEffect(()=>{
        fetchAllEmployees();
    },[]);

    const fetchAllEmployees = () => {
        http.get('/employees').then(res=>{
            setEmployees(res.data);
        })
    }


    const deleteEmployee = (id) => {
        http.delete('/employee/'+id).then(res=>{
            fetchAllEmployees();
        })
    }

    return (
        <div>
            <h2>Employees</h2>
            <table className="table">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>City</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    {employees.map((employee,index)=>(
                        <tr key={employee.id}>
                            <td>{++index}</td>
                            <td>{employee.name}</td>
                            <td>{employee.city}</td>
                            <td>
                                <Link className="btn btn-info" to={{ pathname: "/edit/" + employee.id }}>Edit</Link>&nbsp;
                                <Link className="btn btn-primary" to={{ pathname: "/view/" + employee.id }}>View</Link>&nbsp;
                                <button type="button" className="btn btn-danger"
                                    onClick={()=>{deleteEmployee(employee.id)}}
                                    >Delete</button>
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>

    )
}