import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import http from '../http'


export default function View(props) {
    const [inputs,setInputs] = useState({});
    const {id} = useParams();

    useEffect(()=>{
        fetchEmployee()
    },[]);

    const fetchEmployee= () =>{
        http.get('/employee/'+id).then((res)=>{
            setInputs({
                name:res.data.name,
                city:res.data.city,
            });
        });
    }
    return (
        <div>
            <h2>View Employee</h2>
            <div className="row">
                <div className="col-sm-6">
                    <div className="card p-4">
                        <h4>Name</h4>
                        <p>{ inputs.name }</p>
                        <h4>City</h4>
                        <p>{ inputs.city }</p>

                    </div>
                </div>
            </div>
        </div>

    )
}