import React, {useState} from "react";

function Register() {
    const [username, setUsername] = useState("")
    const [password, setPassword] = useState("")


    async function signIn(){
        let item = {username, password}
        let formData = new FormData();
        formData.append('username', username);
        formData.append('password', password);


        await fetch("http://localhost:8080/api/auth/signin", {
            method: 'POST',
            body: JSON.stringify(item),
            headers:
                {"Content-Type": 'application/json',
                "Accept":  'application/json'}
        })
    }

    return (
        <div>
            <h1>Login page</h1>
            <input type="text" value={username} onChange={(e)=>setUsername(e.target.value)} className="form-control" placeholder="username" />
            <br/>
            <input type="text" value={password} onChange={(e)=>setPassword(e.target.value)} className="form-control" placeholder="password"/>
            <br/>
            <button onClick={signIn} className="btn btn-primary">Sign in</button>
        </div>

    )
}

export default Register