import React, {useState} from "react";

function Register() {
    const [username, setUsername] = useState("")
    const [email, setEmail] = useState("")
    const [password, setPassword] = useState("")


    async function signUp(){
        let formData = new FormData();
        formData.append('username', username);
        formData.append('password', password);
        formData.append('email', email);


            await fetch("http://localhost:8080/login/create", {
            method: 'POST',
            body: formData
        })
    }

    return (
        <div>
            <h1>Register page</h1>
            <input type="text" value={username} onChange={(e)=>setUsername(e.target.value)} className="form-control" placeholder="username" />
            <br/>
            <input type="text" value={email} onChange={(e)=>setEmail(e.target.value)} className="form-control" placeholder="email" />
            <br/>
            <input type="text" value={password} onChange={(e)=>setPassword(e.target.value)} className="form-control" placeholder="password"/>
            <br/>
            <input type="text" className="form-control" placeholder="repeat password"/>
            <br/>
            <button onClick={signUp} className="btn btn-primary">Sign un</button>
        </div>

    )
}

export default Register